package ua.skillsup.jp1.services.converters;

public interface GenericConverter<D, E> {

	D toDto(E entity);

	E toEntity(D dto);
}
