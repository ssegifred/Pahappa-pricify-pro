package org.pahappa.systems.pahappapricifypro.core.services;

import org.pahappa.systems.pahappapricifypro.models.settings.ApplicationSettings;

/**
 * Responsible for CRUD operations on {@link ApplicationSettings}
 */
public interface ApplicationSettingsService extends GenericService<ApplicationSettings> {
    /**
     * Gets {@link ApplicationSettings}
     *
     * @return
     */
    ApplicationSettings getActiveApplicationSettings();
}
