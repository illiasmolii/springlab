package ua.skillsup.jp1.dao.generators;

public abstract class AbstractIdGenerator<E> implements IdGenerator<E> {

	private Long ids = 0L;

	public Long incrementAndGet() {
		return ids++;
	}
}
