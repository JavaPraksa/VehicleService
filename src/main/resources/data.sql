INSERT INTO vehicleservice.address (country, house_number, latitude, longitude, street, town) VALUES
    ('Accusamus', '56', 54312, 754, 'Voluptatibus Maiores', 'Mollitia'),
    ('Itaque', '126', 54312, 754, 'Expedita Distinctio', 'Similique'),
    ('Exercitationem ', '87', 54312, 754, 'Minima Venia', 'Nostrum Quis'),
    ('Itaque', '82', 54312, 754, 'Voluptatibus Maiores', 'Occaecati'),
    ('Country Name', '38a', 54312, 754, 'Street Name', 'Town');

INSERT INTO vehicleservice.vehicle (details, model, price, address_id) VALUES
    ('Nam libero tempore, cum soluta nobis.', 'Car1', 10, 1),
    ('Et harum quidem rerum facilis est et expedita distinctio.', 'Model2', 12, 2),
    ('At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis.', 'Model Name3', 18, 3),
    ('Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe.', 'Car Model4', 13, 4),
    ('Itaque earum rerum hic tenetur a sapiente delectus.', 'Car5', 12, 5),
    ('Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit.', 'Model6', 15, 2),
    ('Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur.', 'CarM7', 15, 4),
    ('Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.', 'Model8', 15, 1);

INSERT INTO vehicleservice.rent (client_id, end_time, start_time, end_address_id, start_address_id, vehicle_id) VALUES
    (2, DATE '2022-03-16', DATE '2022-03-14', 1, 3, 2);