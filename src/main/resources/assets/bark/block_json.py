import json
from pprint import pprint

data = {}
name = input("Block name: ")
texture = input("Texture: ")
with open('blockstates/block.json') as f:
	data = json.load(f)
	data["defaults"]["textures"]["all"] = texture

with open(f'blockstates/{name}.json', 'w+') as f:
	json.dump(data, f)