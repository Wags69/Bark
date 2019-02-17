import json
from pprint import pprint

recipe = {}

name = input('Enter name: ')
recipe['result'] = {}
recipe['result']['item'] = input('Enter result: ')
recipe['result']['count'] = int(input('Enter count: '))
metadata = int(input('Enter data(-1 if none): '))
if metadata != -1:
	recipe['result']['data'] = metadata

recipe['pattern'] = []
height = int(input('Enter height of recipe: '))
for _ in range(height):
	recipe['pattern'].append(input('>> '))

pattern = ''.join(recipe['pattern'])
ingredients = set(pattern)

recipe['type'] = 'forge:ore_shaped'
recipe['key'] = {}

for ingredient in ingredients:
	if ingredient != ' ':
		print(f'{ingredient}:')
		recipe['key'][ingredient] = {}
		if int(input('ore_dict or normal (1 or 0): ')) == 1:
			recipe['key'][ingredient]['type'] = "forge:ore_dict"
			recipe['key'][ingredient]['ore'] = input('Enter ore_dict: ')
		else:
			recipe['key'][ingredient] = {}
			recipe['key'][ingredient]['item'] = input('Enter ingredient: ')
			recipe['key'][ingredient]['count'] = int(input('Enter count: '))
			metadata = int(input('Enter data(-1 if none): '))
			if metadata != -1:
				recipe['key'][ingredient]['data'] = metadata

check = int(input('Enter no. of conditions: '))

if check > 0:
	recipe['conditions'] = []
	for _ in range(check):
		condition = {}
		condition['type'] = input('Enter type: ')
		condition['condition'] = input('Enter condition: ')
		recipe['conditions'].append(condition)

with open(f'recipes/{name}.json', 'w+') as f:
	json.dump(recipe, f)
	