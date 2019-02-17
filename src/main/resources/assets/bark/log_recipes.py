import json
from pprint import pprint

name = input('name: ')
result = input('result: ')
meta = int(input('meta: '))
ing = input('ingredient: ')
data = {}

with open('recipes/log_oak.json') as old, \
    open(f'recipes/{name}.json', 'w+') as new:
    data = json.load(old)
    
    data['result']['item'] = result 
    data['result']['data'] = meta
    data['key']['A']['item'] = ing

    pprint(data)

    json.dump(data, new)
