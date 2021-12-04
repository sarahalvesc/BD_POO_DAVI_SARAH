CREATE DATABASE Supermercado;
Use Supermercado;

CREATE TABLE Funcionario(
    cpf INT NOT NULL,
    nome VARCHAR(40),
    endereco VARCHAR(40),
    telefone INT,
    data_nasc DATE,
	matricula INT AUTO_INCREMENT PRIMARY KEY ,
    salario INT
	);
    #Drop table cartao;
CREATE TABLE Cartao(
	n_cartao INT NOT NULL PRIMARY KEY,
	limite INT,
    data_venc date
);

CREATE TABLE Consumidor (
    cpf INT NOT NULL,
    nome VARCHAR(40),
    endereco VARCHAR(40),
    telefone INT,
    data_nasc DATE,
    mat_consumidor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cartaoID INT,
    CONSTRAINT fk_cartao
    FOREIGN KEY (cartaoID) REFERENCES Cartao(n_cartao) ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


CREATE TABLE Setor(
	codigo INT NOT NULL PRIMARY KEY,
    nome VARCHAR(40),
    localidade VARCHAR(40)
);


CREATE TABLE Compra(
	NUM_COMPRA INT NOT NULL PRIMARY KEY,
    idConsumidor int,
    Valor int,
    CONSTRAINT fk_consumidor
    FOREIGN KEY (idConsumidor) REFERENCES Consumidor(mat_consumidor) ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE Setor_Funcionario(
	funcionarioMAT INT,
    setorCodigo INT,
    PRIMARY KEY (funcionarioMAT, setorCodigo),
    CONSTRAINT fk_funcionario FOREIGN KEY (funcionarioMAT) REFERENCES Funcionario(matricula) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fk_setor FOREIGN KEY (setorCodigo) REFERENCES Setor(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);


SELECT * FROM FUNCIONARIO;
SELECT * FROM SETOR;
SELECT * FROM Setor_Funcionario;
Select * from cartao;
select * from consumidor;
select * from Compra;






