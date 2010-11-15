package org.isistan.flabot.trace.cloud.launcher.cloudProvider;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.isistan.flabot.trace.cloud.ExtensionPointConstants;
import org.isistan.flabot.util.extension.ClassExtensionLoader;
import org.isistan.flabot.util.extension.ClassInstantiator;
import org.isistan.flabot.util.extension.NoMatchingConstructorFoundException;

public class CloudProviderLoader {

	private static final ClassInstantiator<CloudProvider> cloudProviderInstantiator=new ClassInstantiator<CloudProvider>();

	public static IConfigurationElement[] getCloudProviderConfigurationElements(
			IExtension cloudProviderExtension) {

		List<IConfigurationElement> cloudProviders = new LinkedList<IConfigurationElement>();
		for (IConfigurationElement cloudProvider : cloudProviderExtension
				.getConfigurationElements()) {
			if (cloudProvider.getName().equals(
					ExtensionPointConstants.CLOUD_PROVIDER__PROVIDER_TAG)) {
				cloudProviders.add(cloudProvider);
			}
		}
		return cloudProviders
				.toArray(new IConfigurationElement[cloudProviders.size()]);
	}

	public static IConfigurationElement[] getAllCloudProviderConfigurationElements() {

		List<IConfigurationElement> cloudProviders = new LinkedList<IConfigurationElement>();
		System.out.println("Registry: " + Platform.getExtensionRegistry());
		
		
		System.out.println("Registry: " + Platform.getExtensionRegistry().getExtensionPoint("org.isistan.flabot.launcher"));
		System.out.println("Registry: " + Platform.getExtensionRegistry().getExtensionPoint("cloudProvider"));
		System.out.println("Registry: " + Platform.getExtensionRegistry().getExtensionPoint("org.isistan.flabot.launcher.cloudProvider"));
		System.out.println("Registry: " + Platform.getExtensionRegistry().getExtensionPoint("org.isistan.flabot.trace.cloud.cloudProvider"));
		
		IExtensionPoint logPersiterProviderExtensionPoint = Platform
				.getExtensionRegistry().getExtensionPoint(
						ExtensionPointConstants.CLOUD_PROVIDER);

		IExtension[] extensions = logPersiterProviderExtensionPoint
				.getExtensions();
		for (IExtension extension : extensions) {
			IConfigurationElement[] extensionCollectionAction = getCloudProviderConfigurationElements(extension);
			for (IConfigurationElement cloudProvider : extensionCollectionAction) {
				System.out.println("Agregando cloud provider: " + cloudProvider.getName() + " cloudprovider: " + cloudProvider);
				cloudProviders.add(cloudProvider);
			}
		}
		return cloudProviders
				.toArray(new IConfigurationElement[cloudProviders.size()]);
	}

	public static IConfigurationElement getCloudProviderConfigurationElement(
			String cloudProviderId) {
		IConfigurationElement[] cloudProviders = getAllCloudProviderConfigurationElements();
		for (IConfigurationElement cloudProvider : cloudProviders) {
			if (cloudProvider.getAttribute(
					ExtensionPointConstants.CLOUD_PROVIDER__ID_ATTRIBUTE)
					.equals(cloudProviderId)) {
				return cloudProvider;
			}
		}
		return null;
	}

	public static CloudProvider loadCloudProvider(String cloudProviderId)
			throws IllegalArgumentException,
			NoMatchingConstructorFoundException, InstantiationException,
			IllegalAccessException, InvocationTargetException,
			ClassNotFoundException {
		IConfigurationElement cloudProvider = getCloudProviderConfigurationElement(cloudProviderId);
		if (cloudProvider == null) {
			System.out.println("cloudProviderId not found: " + cloudProviderId);
			throw new IllegalArgumentException("cloudProviderId not found");
		}

		Class<? extends CloudProvider> clazz = ClassExtensionLoader
				.<CloudProvider> loadClass(
						cloudProvider,
						ExtensionPointConstants.CLOUD_PROVIDER__PROVIDER_CLASS_ATTRIBUTE);
		return cloudProviderInstantiator.instantiate(clazz);
	}

}
