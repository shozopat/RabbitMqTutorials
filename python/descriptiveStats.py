import pandas as pd
import json
import pika
import sys

connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
channel = connection.channel()
channel.exchange_declare(exchange='direct', exchange_type='direct', durable=True)

def statsCalculator(filePath, cols, id):
	df = pd.read_csv(filePath)
	columns=[];maxs = [];sums=[];mins=[];counts=[];medians=[];stddevs=[];vars=[];means=[];
	cols=['age', 'salary', 'height', 'weight']
	for col in cols:
		columns.append(col)
		medians.append(float(df[col].median()))
		means.append(float(df[col].mean()))
		maxs.append(float(df[col].max()))
		sums.append(float(df[col].sum()))
		mins.append(float(df[col].min()))
		counts.append(float(df[col].count()))
		stddevs.append(float(df[col].std()))
		vars.append(float(df[col].var()))

	data = {}
	data['columns']= columns
	data['medians']= medians	
	data['means']= means
	data['maxs']= maxs
	data['sums']= sums
	data['mins']= mins
	data['counts']= counts
	data['stddevs']= stddevs
	data['vars']= vars
	data['id']=id
	print(data)
	return data
	
#{'file': 'D:\\RabbitMq\\data\\timepass.csv2.csv', 'columns': 'age,salary,height,weight', 'id': '2'}
def callback(ch, method, properties, body):
	print(" [x] %r:%r" % (method.routing_key, body))
	input = json.loads(body)
	print(input)
	result = statsCalculator(input['file'],input['columns'],input['id'])
	sendMessage(result)

def sendMessage(result):
	channel.queue_declare('resultQueue')
	properties = {}
	properties['content-type']='json'
	jsonOutput = json.dumps(result)
	channel.basic_publish(exchange='direct', routing_key='statsResult', body=jsonOutput )
	
channel.queue_declare('statsCalQueue')
channel.queue_bind(exchange='direct', queue='statsCalQueue', routing_key='statsCal')
print(' Waiting for Messages........')

channel.basic_consume(queue='statsCalQueue', on_message_callback=callback, auto_ack=True)
channel.start_consuming()




