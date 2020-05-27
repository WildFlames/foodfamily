insert into category(id, type) values
	(1, 'Soup'),
	(2, 'Pizza'),
	(3, 'Dessert'),
	(4, 'Salad');

insert into product(locale, messagekey, content, price, link, category_id) values
	('en', 'menu.borsh', 'Borsch', 70, 'media/borsh.jpg', 1),
	('ua', 'menu.borsh', 'Борщ', 70, 'media/borsh.jpg', 1),
	('ru', 'menu.borsh', 'Борщ', 70, 'media/borsh.jpg', 1),
	
	('en', 'menu.kharcho', 'Kharcho',  85, 'media/kharcho.jpg', 1),
	('ua', 'menu.kharcho', 'Харчо', 85, 'media/kharcho.jpg', 1),
	('ru', 'menu.kharcho', 'Харчо', 85, 'media/kharcho.jpg', 1),

	
	('en','menu.pepperoni', 'Pepperoni', 140, 'media/pepperoni.png', 2),
	('ua','menu.pepperoni', 'Пеппероні', 140, 'media/pepperoni.png', 2),
	('ru','menu.pepperoni', 'Пепперони', 140, 'media/pepperoni.png', 2),
	
	('en','menu.vegetarian', 'Vegetarian', 110, 'media/vegetarian.jpeg', 2),
	('ua','menu.vegetarian', 'Вегетаріаньска', 110, 'media/vegetarian.jpeg', 2),
	('ru','menu.vegetarian', 'Вегетарианская', 110, 'media/vegetarian.jpeg', 2),
	
	('en','menu.berry.pudding', 'Berry Pudding', 60, 'media/Berry_Pudding.jpg',3),
	('ua','menu.berry.pudding', 'Ягідний Пудинг', 60, 'media/Berry_Pudding.jpg',3),
	('ru','menu.berry.pudding', 'Ягодный Пудинг', 60, 'media/Berry_Pudding.jpg', 3),
	
	('en','menu.greek.salad', '"Greek" Salad', 90, 'media/Greek_Salad.png', 4),
	('ua','menu.greek.salad', 'Салат "Грецький"', 90, 'media/Greek_Salad.png', 4),
	('ru','menu.greek.salad', 'Салат "Греческий"', 90, 'media/Greek_Salad.png', 4),
	
	('en','menu.cesar.salad', 'Cesar Salad', 95, 'media/Cesar_Salad.jpg', 4),
	('ua','menu.cesar.salad', 'Салат "Цезар"', 95, 'media/Cesar_Salad.jpg', 4),
	('ru','menu.cesar.salad', 'Салат "Цезарь"', 95, 'media/Cesar_Salad.jpg', 4),
	
	('en','menu.waldofor.salad', 'Waldorf Salad', 75, 'media/Waldorf_Salad.jpg', 4),
	('ua','menu.waldofor.salad', 'Вальдорфський Cалат', 75, 'media/Waldorf_Salad.jpg', 4),
	('ru','menu.waldofor.salad', 'Вальдорфский Cалат', 75, 'media/Waldorf_Salad.jpg', 4),

	('en','menu.chocolateBananaBread.pudding', 'Chocolate Banana Bread Pudding', 70, 'media/chocolate_banana_bread_pudding.jpg', 3),
	('ua','menu.chocolateBananaBread.pudding', 'Шоколадно-Банановий Пудинг', 70, 'media/chocolate_banana_bread_pudding.jpg', 3),
	('ru','menu.chocolateBananaBread.pudding', 'Шоколадно-Банановый Пудинг', 70, 'media/chocolate_banana_bread_pudding.jpg', 3),

	('en','menu.solyanka', 'Solyanka', 105, 'media/solyanka.jpg', 1),
	('ua','menu.solyanka', 'Солянка', 105, 'media/solyanka.jpg', 1),
	('ru','menu.solyanka', 'Солянка', 105, 'media/solyanka.jpg', 1),
	
	('en','menu.hunting', 'Hunting', 165, 'media/Muslyvska.png', 2),
	('ua','menu.hunting', 'Мисливська', 165, 'media/Muslyvska.png', 2),
	('ru','menu.hunting', 'Охотничья', 165, 'media/Muslyvska.png', 2);