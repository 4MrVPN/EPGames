package de.funit.system.dailyreward;

import java.util.UUID;

import de.funit.system.FileBuilder;

public class Reward {

	FileBuilder fb;
	UUID uuid;

	public Reward(UUID uuid) {
		fb = new FileBuilder("plugins//OwnSystem//DailyRewards", uuid.toString());
		fb.save();
		this.uuid = uuid;
	}

	public void setNormalRewarded(String string) {
		fb.setValue("Reward.Normal.Last", string);
		fb.save();
	}

	public void setPremiumRewarded(String string) {
		fb.setValue("Reward.Premium.Last", string);
		fb.save();
	}

	public String getNormalRewarded() {
		return fb.getString("Reward.Normal.Last");
	}

	public void deleteAllRewards() {
		fb.delete();
	}
	
	public void setFirstJoin() {
		fb.setValue("Reward.Normal.Last", "dd.MM.yyyy");
		fb.setValue("Reward.Premium.Last", "dd.MM.yyyy");
		fb.save();
	}
	
	public boolean dataExist() {
		return fb.contains("Reward");
	}
}
