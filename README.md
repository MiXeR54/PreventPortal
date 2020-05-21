Freaking simple plugin that prevent nether portal creation by non-op players.

The goal was to prevent portal creation by players without permission,
but there is some crap. Spigot API doesn't provide any possibilities to check by whom portal was created.
I used the ignition API method. Which also block ignition non-portal obsidian block.

Tested on Paper-304 (MC: 1.15.2)
