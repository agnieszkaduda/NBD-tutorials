import riak

client = riak.RiakClient()
bucket = client.bucket('s21998')

product = bucket.new('pineapple', data={
    'name': 'Pineapple',
    'type': 'Fruit',
    'price': '8',
    'quantity': '1',
})

#add document to bucket
product.store() 

#retrieve document
product = bucket.get('pineapple')

#print out
print("Added document: " + str(product.data))

#modify
product.data['name'] = 'Banana'
product.store() 

#retrieve document again
product = bucket.get('pineapple')

#print out
print("Document after update: " + str(product.data))

#delete document from db
product.delete()

#retrieve document once again
product = bucket.get('pineapple')
