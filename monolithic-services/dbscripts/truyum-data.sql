USE `truyum` ;

insert into `truyum`.`menu_item` (me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery,me_image_link) values
("Sandwich",99.00,true,'2017-03-15','Main Course',true,'https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1'),
("Burger",129.00,true,'2017-12-23','Main Course',false,'https://images.unsplash.com/photo-1512152272829-e3139592d56f?ixlib=rb-1.2.1'),
("Pizza",149.00,true,'2018-08-21','Main Course',true,'https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?ixlib=rb-1.2.1'),
("French Fries",57.00,false,'2017-07-02','Starters',false,'https://images.unsplash.com/photo-1526230427044-d092040d48dc'),
("Chocolate Brownie",32.00,true,'2022-11-02','Dessert',true,'https://images.unsplash.com/photo-1564355808539-22fda35bed7e?ixlib=rb-1.2.1');

insert into user values(1,'user','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');
insert into user values(2,'admin','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');
insert into user values(3,'default','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');
