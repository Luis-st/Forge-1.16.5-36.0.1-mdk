package net.luis.cave.api.lib;

import net.minecraft.world.GameRules;

public class GameRule {
	
	private final String name;
	private final GameRules.Category category;
	private GameRules.RuleKey<?> rule;

	public GameRule(String name, GameRules.Category category) {
		
        this.name = name;
        this.category = category;
        
    }

	public String getName() {
		
		return this.name;
		
	}

	public GameRules.Category getCategory() {
		
		return this.category;
		
	}

	public GameRules.RuleKey<?> getRule() {
		
		return this.rule;
		
	}

	public void setRule(final GameRules.RuleKey<?> ruleKey) {
		
		this.rule = ruleKey;
		
	}
	
	public static class BooleanGameRule extends GameRule {

		private final boolean defaultValue;

		public BooleanGameRule(String name, GameRules.Category category, boolean defaultValue) {

			super(name, category);
			this.defaultValue = defaultValue;

		}

		@Override
		@SuppressWarnings("unchecked")
		public GameRules.RuleKey<GameRules.BooleanValue> getRule() {
			
			return (GameRules.RuleKey<GameRules.BooleanValue>) super.getRule();
			
		}
		
		public boolean getDefaultValue() {

			return this.defaultValue;

		}

	}
	
	public static class IntegerGameRule extends GameRule {
		
		private final int defaultValue;

		public IntegerGameRule(String name, GameRules.Category category, int defaultValue) {
			
			super(name, category);
			this.defaultValue = defaultValue;
			
		}

		@Override
		@SuppressWarnings("unchecked")
		public GameRules.RuleKey<GameRules.IntegerValue> getRule() {
			
			return (GameRules.RuleKey<GameRules.IntegerValue>) super.getRule();
			
		}

		public int getDefaultValue() {
			
			return this.defaultValue;
			
		}
		
	}

}
