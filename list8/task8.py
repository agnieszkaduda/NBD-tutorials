import riak

client = riak.RiakClient()
bucket = client.bucket('s21998')

new_product = bucket.new('pineapple', data={
    'name': 'Pineapple',
    'type': 'Fruit',
    'price': '8',
    'quantity': '1',
})

#add document to bucket
new_product.store() 






bucket_name = 's_15293'
ssd_key = 'ssd'

my_client = RiakClient(protocol='http', host='localhost', http_port=8098)
my_bucket = my_client.bucket(bucket_name)
# add product to db
ssd_data = {"name": "970 EVO Plus", "producer": "Samsung", "price": 350, "capacityGb": 500}
ssd = my_bucket.new(ssd_key, data=ssd_data)
ssd.store()
print('added product')
# add_product(ssd_key, ssd_data)
# retrieve product
ssd = fetch_and_print(ssd_key)
# modify product
ssd.data["name"] = "Samsung 970 EVO Plus updated"
ssd.store()
print('updated')
# retrieve updated
ssd = fetch_and_print(ssd_key)
# delete
ssd.delete()
print('deleted')
# try to retrieve deleted
ssd = fetch_and_print(ssd_key)