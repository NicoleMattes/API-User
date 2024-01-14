-- Relacionamento para usuario_cpf
ALTER TABLE user_cpf
ADD CONSTRAINT fk_user_cpf_endereco
FOREIGN KEY (endereco_id) REFERENCES address(id)
ON DELETE CASCADE;

-- Relacionamento para usuario_cnpj
ALTER TABLE address
ADD CONSTRAINT fk_address_user_cnpj
FOREIGN KEY (id) REFERENCES user_cnpj(id)
ON DELETE CASCADE;