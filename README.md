Nations
====================
#####The idea behind this plugin is to create an active pvp environment between different groups of players (nations).

###Current features:
- Help-commands
- Generate config file
- Join nation through commands
- Maven integration (No dependencies yet)
- Save / load player-data to / from file
- Disable pvp between players from the same nation

###To-do:
Higher on the list means higher priority

- Support for UUIDs
- Update to latest Bukkit beta build (1.7.9)
- Nation traits
- Disable nation 'jumping' (Admin command should be able to change a player's nation directly though)
- Set nation spawn (admin command | /n set spawn <nation>)
- Teleport command to nation capital for players (only in their active nation)
- Optimize saving / loading
- Build-protection in an area around the nation spawn. (Ability to override with WorldGuard? Useful for houses inside the capital)
- Create config.yml with plugin-options
- More admin commands
- Additional nation info in-game
- Nation name under holo-nametag. Alternatively: Nation tag + color in nametag
- Settlements (Will be specified at a later date)
- Everything else

###Contributors
[![Ionaru](http://www.gravatar.com/avatar/870462a1ed323405ffb155fd0f3b3258.png)]
(https://github.com/Ionaru)
[![endercrest](https://s.gravatar.com/avatar/110c2638b7505c44d04ac720bec943f9?s=80)]
(https://github.com/endercrest)
[![mythbusterma](http://i.imgur.com/k11WQDw.png)]
(https://github.com/mythbusterma)

###Nations idea as seen on Bukkit forums
####Back story:
Hi, I have been sitting on an idea for a server for a long time. It's going to be a role playing server where you play as a late-17th century explorer who set out to explore and colonize the "New World". I have the worlds and basics done but have been problems with getting the plugins to do exactly what I want. As I have absolutely zero experience with coding I am asking you guys for help. I will be able to provide a testing server if needed.

####What I want (short): 
I want players to be able to choose a nation as their 'team' and then be able to make towns inside that nation. (reverse Towny). It would be really cool if the different nations could have little traits to them.
The nations would be in constant war with each other, allowing the players to engage in battle or even destroy blocks of the other nation (with the exception of the nation capital).

####What I want (long):
I have been working with Towny and Factions before, but they do not provide exactly what I need.
My idea is that the player joins a nation/country/faction first and is then able to create towns/settlements under that nation's flag. My original idea was to have four nations, but there could be more to choose from, maybe enable/disable nations in a config file.

Each nation will have a designated capital city that can not be attacked, players of that nation will be safe here. Player-created settlements however are vulnerable.
Players from other nations that enter a capital of another nation will get a warning, other players can attack that player without taking damage themselves.

The traits idea came from Mcmmo, it makes players choose a nation carefully. I think it can really improve gameplay to have that little extra trait.

Players from other factions can be identified by the nation's name under the player name tag.

The area that belongs to a nation's capital or settlements is done by claiming chunks (like in towny).

Players from other nations are able to destroy blocks in settlements belonging to another nation, but not chests.

After players in a settlement are offline for a certain amount of time (configurable?) the settlement will fall and players can then take everything.

Players should not be able to jump from one nation to another too often as that could be exploited, a limit of one switch every week sounds reasonable.

A neutral ground should also exist, players cannot break blocks or pvp here. This is useful as a spawnpoint, global market with shops or minigame area. This could be another world (Disable Nations in certain worlds).

####Main nations idea + traits:
- England:Extra damage with bow & arrow in combat
- Netherlands: Gain a % of money each day (interest over current balance)
- France: Bonus resistance from armor
- Spain: Chance for extra drops while mining

#####Additional nations + traits
- Germany: Chance to get one extra ingot in smelting
- Switzerland: Chance to get some money from killing mobs
- Italy: Extra loot from mobs
- Portugal: Extra damage with swords and axes
- Belgium: Extra food nourishment

####Extra idea: Sieges
In this idea, players can not destroy blocks of another nation's settlement, instead they can declare a siege. The town will get a big warning message that an enemy town is attacking it and they can either declare counter-siege or to defend.
In counter-siege both towns will have to kill as many town-members of the other town as possible. The town with the most kills will be victorious and the losing town will fall.
In defend the enemy destroys an X amount of blocks (not chests) in the town they declared a siege on. If the damage is not repaired in an X amount of time (2-3 days) by the defending side, the town will fall.

####Ideas for commands: 
- '/nation' Show plugin commands or nation info when in a nation
- '/nation join <nation_name>' For new players to join a nation
- '/nation switch' Switch between nations
- '/nation settle' Create a town in your nation
- '/nation help' Show plugin commands

####Ideas for permissions:
- nation.join.<nation>
- nation.switch
- nation.admin (Can build/destroy/attack everywhere, can also set capital bounds)
- nation.settle
