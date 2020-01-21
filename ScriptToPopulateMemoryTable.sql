insert into locations_memory (id,name,location,closest_requests)  
select id,name,AsText(location),closest_requests from locations;