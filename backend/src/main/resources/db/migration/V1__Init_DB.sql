CREATE TABLE polzovateli (
    id BIGSERIAL PRIMARY KEY,
    imya VARCHAR(255) NOT NULL,
    familiya VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    rol VARCHAR(50) NOT NULL
);

CREATE TABLE vstrechi (
    id BIGSERIAL PRIMARY KEY,
    vremya_nachala TIMESTAMP NOT NULL,
    vremya_okonchaniya TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL
);

CREATE TABLE uchastniki_vstrechi (
    vstrecha_id BIGINT REFERENCES vstrechi(id),
    polzovatel_id BIGINT REFERENCES polzovateli(id),
    PRIMARY KEY (vstrecha_id, polzovatel_id)
);