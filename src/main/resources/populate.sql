INSERT INTO `GoIT`.`companies` (`id`, `name`) VALUES ('1', 'Google');
INSERT INTO `GoIT`.`companies` (`id`, `name`) VALUES ('2', 'Apple');
INSERT INTO `GoIT`.`companies` (`id`, `name`) VALUES ('3', 'Microsoft');

INSERT INTO `GoIT`.`customers` (`id`, `name`) VALUES ('1', 'John');
INSERT INTO `GoIT`.`customers` (`id`, `name`) VALUES ('2', 'Alex');
INSERT INTO `GoIT`.`customers` (`id`, `name`) VALUES ('3', 'Bob');

INSERT INTO `GoIT`.`developers` (`id`, `name`, `phone`) VALUES ('1', 'Sasha', '123123');
INSERT INTO `GoIT`.`developers` (`id`, `name`, `phone`) VALUES ('2', 'John', '32123');
INSERT INTO `GoIT`.`developers` (`id`, `name`, `phone`) VALUES ('3', 'July', '222222');
INSERT INTO `GoIT`.`developers` (`id`, `name`, `phone`) VALUES ('4', 'Martin', '213123');

INSERT INTO `GoIT`.`skills` (`id`, `name`) VALUES ('1', 'Java');
INSERT INTO `GoIT`.`skills` (`id`, `name`) VALUES ('2', 'C++');
INSERT INTO `GoIT`.`skills` (`id`, `name`) VALUES ('3', 'Python');

INSERT INTO `GoIT`.`projects` (`id`, `name`) VALUES ('1', 'web application');
INSERT INTO `GoIT`.`projects` (`id`, `name`) VALUES ('2', 'application2');
INSERT INTO `GoIT`.`projects` (`id`, `name`) VALUES ('3', 'engine');
INSERT INTO `GoIT`.`projects` (`id`, `name`) VALUES ('4', 'somePrj');

INSERT INTO `GoIT`.`dev_comp` (`devId`, `compID`) VALUES ('1', '1');
INSERT INTO `GoIT`.`dev_comp` (`devId`, `compID`) VALUES ('2', '1');
INSERT INTO `GoIT`.`dev_comp` (`devId`, `compID`) VALUES ('4', '1');
INSERT INTO `GoIT`.`dev_comp` (`devId`, `compID`) VALUES ('3', '2');

INSERT INTO `GoIT`.`dev_skill` (`devID`, `skillID`) VALUES ('1', '1');
INSERT INTO `GoIT`.`dev_skill` (`devID`, `skillID`) VALUES ('1', '2');
INSERT INTO `GoIT`.`dev_skill` (`devID`, `skillID`) VALUES ('1', '3');
INSERT INTO `GoIT`.`dev_skill` (`devID`, `skillID`) VALUES ('2', '1');
INSERT INTO `GoIT`.`dev_skill` (`devID`, `skillID`) VALUES ('3', '1');
INSERT INTO `GoIT`.`dev_skill` (`devID`, `skillID`) VALUES ('4', '1');
INSERT INTO `GoIT`.`dev_skill` (`devID`, `skillID`) VALUES ('4', '3');

INSERT INTO `GoIT`.`prj_cust` (`prjID`, `custID`) VALUES ('1', '1');
INSERT INTO `GoIT`.`prj_cust` (`prjID`, `custID`) VALUES ('2', '1');
INSERT INTO `GoIT`.`prj_cust` (`prjID`, `custID`) VALUES ('3', '2');
INSERT INTO `GoIT`.`prj_cust` (`prjID`, `custID`) VALUES ('4', '3');

INSERT INTO `GoIT`.`proj-dev` (`prjID`, `devID`) VALUES ('1', '1');
INSERT INTO `GoIT`.`proj-dev` (`prjID`, `devID`) VALUES ('1', '2');
INSERT INTO `GoIT`.`proj-dev` (`prjID`, `devID`) VALUES ('2', '3');
INSERT INTO `GoIT`.`proj-dev` (`prjID`, `devID`) VALUES ('3', '4');