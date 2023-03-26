Даны две таблицы :

Persons со списком работников

Id	Name
1	Petya
2	Vasya
3	Kolya

Payments с зарплатными начислениями ежемесячно.

Id	Persons_id	Value
1		1		10
2		1		20
3		3		15

выбрать сотрудников у которых общий размер начислений превышает 20

select p.name
from persons p
join payments pp on p.id = pp.Persons_id
where pp.value > 20



