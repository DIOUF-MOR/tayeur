package org.sid.tayeur_app.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.sid.tayeur_app.dto.ClientDto;
import org.sid.tayeur_app.dto.response.ClientResponse;
import org.sid.tayeur_app.entities.Client;
import org.sid.tayeur_app.enums.GenreClient;
import org.sid.tayeur_app.repositories.ClientRepository;
import org.sid.tayeur_app.repositories.CommandeRepository;
import org.sid.tayeur_app.repositories.ModelRepository;
import org.sid.tayeur_app.services.interfaces.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientInterface {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public ClientResponse saveClient(ClientDto clientDto){
        Client client = ClientDto.toEntity(clientDto);

        return ClientDto.fromEntityResponse( clientRepository.save(client));
    }
    @Override
    public Set<ClientResponse> getAll(){
        return clientRepository.findAll().stream().map(ClientDto::fromEntityResponse).collect(Collectors.toSet());
    }

    @Override
    public Optional<ClientResponse> getById(Long id){
        return clientRepository.findById(id).map(ClientDto::fromEntityResponse);
    }
    @SneakyThrows
    @Override
    public void delete(Long id) {
        clientRepository.delete(clientRepository.findById(id).orElseThrow(()-> new NotFoundException("Le client avec l'id :"+ id + "n'a pas été trouvé!")));
    }
}
