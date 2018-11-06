package co.cantina.springjooq.services;

import java.util.List;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.cantina.spring.jooq.sample.model.Tables;

import co.cantina.springjooq.domain.Book;

@Service
public class BookService {

	@Autowired
	private ModelMapper mapper;
			
	@Autowired
	DSLContext dsl;

	public List<Book> getBooks() {
		return dsl
				.selectFrom(Tables.BOOKS)
				.fetch()
				.stream()
				.map(e -> mapper.map(e, Book.class))
				.collect(Collectors.toList());
	}
}
