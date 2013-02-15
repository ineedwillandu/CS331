package userDefinedInterface;

public interface MyIterator<E> {
	public E get();
	public void next();
	public boolean isValid();
//	public void delete();
}
