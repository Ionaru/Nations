package me.ionaru.nations;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

/**
 * Stores all the attributes necessary to keep track of the player
 * 
 * @author Snake
 *
 */
public class PlayerAttributes implements ConfigurationSerializable {
	
	private NationType nation;
	private String lastName; // last known name of the player
	
	public PlayerAttributes (NationType _nation, String name) {
		nation = _nation;
		lastName = name;
	}
	
	public PlayerAttributes (Map<String,Object> map) {
		lastName = (String) map.get("lastName");
		nation = NationType.fromId((Integer) map.get("nation"));
	}
	
	@Override
	public Map<String, Object> serialize() {
		Map<String,Object> temp = new HashMap<String,Object> ();
		temp.put("nation", nation.getId());
		temp.put("lastName", lastName);
		return null;
	}

	public void setNation(NationType type) {
		nation = type;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String name) {
		lastName = name;
	}

	public NationType getNation() {
		return nation;
	}

}
