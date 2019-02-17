import json

name = input('name: ')
result = input('result: ')
ing = input('ingredient: ')
meta = int(input('meta: '))
data = {}

with open('recipes/bark_oak.json') as old, \
    open(f'recipes/{name}.json', 'w+') as new:
    data = json.load(old)
    data['result']['item'] = result
    data['key']['A']['item'] = ing
    data['key']['A']['data'] = meta

    json.dump(data, new)
