package net.b0at.api.event;

import net.b0at.api.event.types.EventPriority;
import net.b0at.api.event.types.EventTiming;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * Indicates a {@link Method} should be invoked when the designated event is fired in an {@link EventManager}.
 *
 * <p>
 * A proper {@link EventHandler} {@link Method} has either ONE (1) or TWO (2) parameters.
 * <br>
 * If the {@link Method} has ONE parameter, it must have a type that extends the {@link EventManager}'s {@link EventManager#BASE_CLASS}.
 * This method will only be invoked with the specified {@link #timing()}.
 * <br>
 * If the {@link Method} has TWO parameters, the first parameter must have a type that extends the {@link EventManager}'s {@link EventManager#BASE_CLASS},
 * and the second parameter have the type {@link EventTiming}. This method will be invoked for both {@link EventTiming#PRE}
 * and {@link EventTiming#POST} events.
 * </p>
 *
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
    /**
     * Indicates the priority of this {@link EventHandler}, by default set to {@link EventPriority#MEDIUM}.
     *
     * @see EventPriority
     *
     * @return the priority of this {@link EventHandler}
     */
    EventPriority priority() default EventPriority.MEDIUM;

    /**
     * Indicates the timing of this {@link EventHandler}, by default set to {@link EventTiming#PRE}.
     *
     * @see EventTiming
     *
     * @return the timing of this {@link EventHandler}
     */
    EventTiming timing() default EventTiming.PRE;

    /**
     * Indicates if this {@link EventHandler} is persistent or not persistent.
     *
     * <p>
     * Although this is implementation specific, {@code persistent} {@link EventHandler}s are typically registered at the start
     * of program execution or before the desired event will be invoked for the first time, whereas {@code non-persistent}
     * {@link EventHandler}s are typically {@code registered} and {@code deregistered} throughout the runtime of the application.
     * </p>
     *
     * @return if this {@link EventHandler} should be persistent or not persistent
     */
    boolean persistent() default false;
}
