package task07.util.migrate;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
public class MigrateContext {
	private MigrateStrtegy migrateStrtegy;

	public MigrateContext(MigrateStrtegy migrateStrtegy){
		this.migrateStrtegy = migrateStrtegy;
	}

	public void executeStrategy(String targetOSS) {
		migrateStrtegy.migrate(targetOSS);

	}
}
