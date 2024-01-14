package api.apiuser.api.repository;

import api.apiuser.api.repository.model.UserCpfModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCpfRepository extends JpaRepository<UserCpfModel, String> {
    UserCpfModel findByCpf(String cpf);

    UserCpfModel findByEmail(String email);
}
