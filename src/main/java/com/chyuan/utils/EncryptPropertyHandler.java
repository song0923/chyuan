/*package com.chyuan.utils;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyHandler extends PropertyPlaceholderConfigurer {
	private static final String USER = "c3p0.user";
	private static final String PASSWORD = "c3p0.password";
	private static final String JDBCURL = "c3p0.jdbcurl";
	private static final String DRIVERCLASS = "c3p0.driverclass";
	private static final String RANDOM_KEY = Utils.randomKey();

	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
		try {
			String user = props.getProperty(USER);
			if (StringUtils.isNotEmpty(user)) {
				props.setProperty(USER, CryptUtils.decrypt(user, RANDOM_KEY));
			}

			String password = props.getProperty(PASSWORD);
			if (StringUtils.isNotEmpty(password)) {
				props.setProperty(PASSWORD, CryptUtils.decrypt(password, RANDOM_KEY));
			}

			String url = props.getProperty(JDBCURL);
			if (StringUtils.isNotEmpty(url)) {
				props.setProperty(JDBCURL, CryptUtils.decrypt(url, RANDOM_KEY));
			}

			String driverClassName = props.getProperty(DRIVERCLASS);
			if (StringUtils.isNotEmpty(driverClassName)) {
				props.setProperty(DRIVERCLASS, CryptUtils.decrypt(driverClassName, RANDOM_KEY));
			}

			super.processProperties(beanFactory, props);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BeanInitializationException(e.getMessage());
		}
	}
}
*/