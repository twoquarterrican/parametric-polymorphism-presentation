package examples;

/**
 * <pre>
 * Details on ? extends versus ? super.
 *
 * If using ? super X, draw an arrow from X to ?: X ---> ?
 * For any piece of api, you want to use, draw it as an arrow from inputs to outputs.
 * For example, List.add has the following signature:
 *
 *  boolean add(E e);
 *
 *  So the input type is ? and the output type is boolean.  We draw E ---> boolean.
 *
 *  Now the api we actually want to use is MyObject x = ...; list.add(x); so this is MyObject ---> boolean,
 *  but ? ---> boolean is what we must make use of.  So we need to fill in the following diagram
 *
 *             MyObject
 *                |
 *                |want
 *        have    v
 *      ? ---> boolean
 *
 *  Clearly, we can get from MyObject to boolean if we have a line from MyObject to ?.  Therefore,
 *  we can use list.add(x) if we have ? super MyObject.
 *
 *  On the other hand, if we want to get a MyObject from the list, we want get : int ---> MyObject,
 *  but we have int ---> ?.
 *
 *     int ------> MyObject
 *      |   want
 *  have|
 *      v
 *      ?
 *
 *  Clearly an arrow ? ---> MyObject will allow you to travel from int to ? to MyObject, and get the
 *  arrow you want.  This means we should use the constraint ? extends MyObject in this case.
 * </pre>
 */
public class Example20 {
}
