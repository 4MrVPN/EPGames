package de.funit.system;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileBuilder {
	
	private File f;
	private YamlConfiguration c;

	public FileBuilder(String FilePath, String FileName) {
		f = new File(FilePath, FileName);
		c = YamlConfiguration.loadConfiguration(f);
	}

	public FileBuilder setValue(String ValuePath, Object Value) {
		c.set(ValuePath, Value);
		return this;
	}

	public void delete() {
		f.delete();
	}

	public boolean contains(String ValuePath) {
		return c.contains(ValuePath);
	}
	
	public boolean exist() {
		return f.exists();
	}
	public Object getObject(String ValuePath) {
		return c.get(ValuePath);
	}

	public int getInt(String ValuePath) {
		return c.getInt(ValuePath);
	}

	public long getLong(String ValuePath) {
		return c.getLong(ValuePath);
	}
	
	public double getDouble(String ValuePath) {
		return c.getDouble(ValuePath);
	}

	public List<Byte> getByte(String ValuePath) {
		return c.getByteList(ValuePath);
	}

	public boolean getBoolean(String ValuePath) {
		return c.getBoolean(ValuePath);
	}
	
	public String getString(String ValuePath) {
		return c.getString(ValuePath);
	}
	
	public List<String> getStringList(String ValuePath) {
		return c.getStringList(ValuePath);
	}

	public Set<String> getKeys(boolean deep) {
		return c.getKeys(deep);
	}

	public ConfigurationSection getConfiguratinSection(String Section) {
		return c.getConfigurationSection(Section);
	}

	public FileBuilder save() {
		try {
			c.save(f);
		} catch (IOException localIOException) {
		}
		return this;
	}
}