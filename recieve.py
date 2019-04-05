import pika
import sys

connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
channel = connection.channel()

channel.exchange_declare(exchange='direct', exchange_type='direct', durable=True)

result = channel.queue_declare('', exclusive=True)
queue_name = result.method.queue

severities = ['info','warn','error'];

for severity in severities:
	channel.queue_bind(exchange='direct', queue=queue_name, routing_key=severity)

print(' [*] Waiting for logs. To exit press CTRL+C')


def callback(ch, method, properties, body):
    print(" [x] %r:%r" % (method.routing_key, body))

channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)
channel.start_consuming()