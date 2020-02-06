USE AUCA_DB;

ALTER TABLE Students 
    ADD FOREIGN KEY (MaritalStatusId) REFERENCES MaritalStatuses(Id);
