package api.apiuser.api.repository;

import api.apiuser.api.repository.model.UserCnpjModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCnpjRepository extends JpaRepository<UserCnpjModel, String> {
   UserCnpjModel findByEmail(String email);

   UserCnpjModel findByCnpj(String cnpj);


}
