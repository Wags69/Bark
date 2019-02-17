import json
from pprint import pprint

data = {}
name = input("Block name: ")
texture = input("Texture: ")
with open('blockstates/bark_ironwood_table.json') as old, \
	open(f'blockstates/{name}_table.json', 'w+') as new:
	data = json.load(old)
	for i, j in enumerate(data['multipart']):
		if 'when' in j:
			data['multipart'][i]['apply']['model'] = f'bark:{name}_table_leg_nw'
		else:
			data['multipart'][i]['apply']['model'] = f'bark:{name}_table_top'

	json.dump(data, new)

with open('models/block/bark_ironwood_table_top.json') as old, \
	open(f'models/block/{name}_table_top.json', 'w+') as new:
	data = json.load(old)
	data['textures']['0'] = data['textures']['particle'] = texture 

	json.dump(data, new)

with open('models/block/bark_ironwood_table_leg_nw.json') as old, \
	open(f'models/block/{name}_table_leg_nw.json', 'w+') as new:
	data = json.load(old)
	data['textures']['0'] = data['textures']['particle'] = texture 

	json.dump(data, new)

with open('models/item/bark_ironwood_table.json') as old, \
	open(f'models/item/{name}_table', 'w+') as new:
	data = { "parent": f"bark:block/{name}_table_top"	}
	json.dump(data, new)

a = """
registerRender(Item.getItemFromBlock(barkOliveTable));
      registerRender(Item.getItemFromBlock(barkOakTable));
      registerRender(Item.getItemFromBlock(barkAcaciaTable));
      registerRender(Item.getItemFromBlock(barkBirchTable));
      registerRender(Item.getItemFromBlock(barkDarkOakTable));
      registerRender(Item.getItemFromBlock(barkJungleTable));
      registerRender(Item.getItemFromBlock(barkSpruceTable));

{
  "conditions": [
    {
      "type": "mod_loaded",
      "mod": "minecraft"
    }
  ],
  "type": "minecraft:crafting_shaped",
  "group": "random_things",
  "pattern": [
    "###",
    "XXX"
  ],
  "key": {
    "#": {
      "item": "#PLANKS"
    },
    "X": [
      {
        "item": "#PLANKS"
      },
      {
        "item": "#MIXED",
      },
      {
        "item": "minecraft:planks",
        "data": 2
      }
    ]
  },
  "result": {
    "item": "minecraft:bed",
    "data": 15
  }
}
"""