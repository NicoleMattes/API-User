package api.apiuser.api.repository;

import api.apiuser.api.repository.model.AddressModel;
import api.apiuser.api.repository.model.UserCpfModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, String> {
}
