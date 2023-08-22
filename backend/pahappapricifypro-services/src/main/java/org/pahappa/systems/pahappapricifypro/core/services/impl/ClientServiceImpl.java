package org.pahappa.systems.pahappapricifypro.core.services.impl;

import org.pahappa.systems.pahappapricifypro.core.services.ClientService;
import org.pahappa.systems.pahappapricifypro.models.client.Client;
import org.pahappa.systems.pahappapricifypro.utils.Validate;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.model.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl extends GenericServiceImpl<Client> implements ClientService {
    @Override
    public Client saveInstance(Client entityInstance) throws ValidationFailedException, OperationFailedException {
        Validate.notNull(entityInstance,"Entity attributes are required");
        return save(entityInstance);
    }

    @Override
    public boolean isDeletable(Client instance) throws OperationFailedException {
        return true;
    }
}
