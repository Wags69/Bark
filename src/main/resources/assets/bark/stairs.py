import json
from pprint import pprint

data = {}
name = input("Block name (stairs will be added by the script): ")

#BLOCKSTATE
with open('blockstates/stairs.json') as f:
	data = json.load(f)
	for i in data['variants']:
		if 'outer' in i:
			data['variants'][i]['model'] = f'bark:{name}_outer_stairs'
		elif 'inner' in i:
			data['variants'][i]['model'] = f'bark:{name}_inner_stairs'
		else:
			data['variants'][i]['model'] = f'bark:{name}_stairs'

with open(f'blockstates/{name}_stairs.json', 'w+') as f:
	json.dump(data, f)

#MODELS
bottom = input('bottom texture: ')
top = input('top texture: ')
side = input('side texture: ')

inner, outer, stairs = {}, {}, {}
with open('models/block/stairs.json') as f:
	stairs = json.load(f)
	stairs['textures']['bottom'] = bottom
	stairs['textures']['top'] = top
	stairs['textures']['side'] = side

with open('models/block/inner_stairs.json') as f:
	inner = json.load(f)
	inner['textures']['bottom'] = bottom
	inner['textures']['top'] = top
	inner['textures']['side'] = side

with open('models/block/outer_stairs.json') as f:
	outer = json.load(f)
	outer['textures']['bottom'] = bottom
	outer['textures']['top'] = top
	outer['textures']['side'] = side

with open(f'models/block/{name}_inner_stairs.json', 'w+') as i, \
	open(f'models/block/{name}_outer_stairs.json', 'w+') as o, \
	open(f'models/block/{name}_stairs.json', 'w+') as s:
	json.dump(inner, i)
	json.dump(outer, o)
	json.dump(stairs, s)

with open(f'models/item/{name}_stairs.json', 'w+') as f:
	dic = { "parent": f"bark:block/{name}_stairs" }
	json.dump(dic, f)