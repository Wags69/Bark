import json

name = input()
texture = input()
data = {}
with open('blockstates/bark_ironwood_chair.json') as old, \
	open(f'blockstates/{name}_chair.json', 'w+') as new:
	data = json.load(old)
	for i in data['variants']:
		data['variants'][i]['model'] = f'bark:{name}_chair'

	json.dump(data, new)

with open('models/block/bark_ironwood_chair.json') as old, \
	open(f'models/block/{name}_chair.json', 'w+') as new:
	data = json.load(old)
	data['textures']['0'] = texture
	data['textures']['particle'] = texture

	json.dump(data, new)

with open(f'models/item/{name}_chair.json', 'w+') as new:
	data = { "parent": f"bark:block/{name}_chair"	}
	json.dump(data, new)