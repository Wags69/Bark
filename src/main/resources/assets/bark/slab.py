import json
from pprint import pprint

data = {}
name = input()
side = input()
top = input()
bottom = input()

with open('blockstates/double_slab.json') as old, \
	open(f'blockstates/{name}_double_slab.json', 'w+') as new:
	data = json.load(old)

	data["variants"]["variant=default"]["model"] = f'bark:{name}_double_slab'

	json.dump(data, new)

with open('blockstates/slab.json') as old, \
	open(f'blockstates/{name}_slab.json', 'w+') as new:
	data = json.load(old)

	data["variants"]["half=bottom,variant=default"]["model"] = f'bark:{name}_bottom_slab'
	data["variants"]["half=top,variant=default"]["model"] = f'bark:{name}_top_slab'

	json.dump(data, new)

with open('models/block/top_slab.json') as old, \
	open(f'models/block/{name}_top_slab.json', 'w+') as new:
	data = json.load(old)

	data['textures']['bottom'] = bottom
	data['textures']['top'] = top
	data['textures']['side'] = side

	json.dump(data, new)

with open('models/block/bottom_slab.json') as old, \
	open(f'models/block/{name}_bottom_slab.json', 'w+') as new:
	data = json.load(old)

	data['textures']['bottom'] = bottom
	data['textures']['top'] = top
	data['textures']['side'] = side

	json.dump(data, new)

with open('models/block/double_slab.json') as old, \
	open(f'models/block/{name}_double_slab.json', 'w+') as new:
	data = json.load(old)

	data['textures']['end'] = bottom
	data['textures']['side'] = side

	json.dump(data, new)

with open(f'models/item/{name}_slab.json', 'w+') as new:
	data = { "parent": f"bark:block/{name}_bottom_slab" }
	json.dump(data, new)