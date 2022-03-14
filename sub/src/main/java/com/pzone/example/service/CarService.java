package com.pzone.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pzone.example.model.Car;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLSubscription;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class CarService {

	private static List<Car> ls = new ArrayList<Car>();
//	final static private Logger LOG = LogManager.getLogger(GraphQLPrivider.class);

	static {
		ls.add(new Car(1, "scorpio", "bhargav"));
		ls.add(new Car(2, "fortuner", "akshay"));
		ls.add(new Car(3, "audi", "kaushik"));
		ls.add(new Car(4, "ford", "public"));
	}

	@GraphQLQuery(name = "carbyid")
	public Car getCarById(@GraphQLArgument(name = "id") Integer id) {

		for (Car s : ls) {

			if (s.getCid().equals(id)) {
				// LOG.info(s);
				return s;
			}
		}

		return null;
	}

	@GraphQLQuery(name = "cars")
	public List<Car> getCars() {
		return ls;
	}
	
	@GraphQLSubscription(name = "car") 
	public List<Car> Cars() {
		return ls;
	}
	
    @GraphQLMutation(name = "savecar") 
	public Boolean setCar(@GraphQLArgument(name = "s") Car s) {
    	
		return ls.add(s);
	}
    
    @GraphQLMutation(name="delcarbyid")
	public Boolean delCar(@GraphQLArgument(name = "id") Integer id) {
		for (Car s : ls) {
			if (s.getCid() == id) {
				ls.remove(ls.indexOf(s));
				return true;
			}
		}
		return false;
	}
    @GraphQLMutation(name="upcarbyid")
	public Boolean upCar(@GraphQLArgument(name = "s") Car s, @GraphQLArgument(name = "id") Integer id) {

		int i = -1;
		for (Car s1 : ls) {
			if (s1.getCid() == id) {
				i = ls.indexOf(s1);
			}
		}

		if (i != -1) {
			ls.set(i, s);
			return true;
		}
		return false;
	}
}
