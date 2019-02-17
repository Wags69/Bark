import json
from pprint import pprint

data = {}
name = input()
bottom = input()
top = input()
side = input()

#BLOCKSTATE
with open('blockstates/bark_acacia_stairs.json') as f:
	data = json.load(f)
	data['defaults']['textures'] = {
          "bottom": bottom,
          "top": top,
          "side": side,
          "particle": side
        }

with open(f'blockstates/{name}_stairs.json', 'w+') as f:
	json.dump(data, f)