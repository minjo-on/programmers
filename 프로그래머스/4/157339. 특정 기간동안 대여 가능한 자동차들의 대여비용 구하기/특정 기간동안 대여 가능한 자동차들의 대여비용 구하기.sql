-- 코드를 입력하세요
SELECT c.car_id, c.car_type, floor(c.daily_fee * 30 * (1 - (p.discount_rate / 100))) as fee
from car_rental_company_car c 
join car_rental_company_discount_plan p on c.car_type = p.car_type and p.duration_type = '30일 이상'
where c.car_type in ('세단', 'suv')
and c.car_id not in (
    select r.car_id
    from car_rental_company_rental_history r
    where r.start_date <= date '2022-11-30'
    and r.end_date >= date '2022-11-01'
)
and (c.daily_fee * 30 * (1 - (p.discount_rate / 100))) >= 500000
and (c.daily_fee * 30 * (1 - (p.discount_rate / 100))) < 2000000
order by fee desc, c.car_type asc, c.car_id desc;