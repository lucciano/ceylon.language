package com.redhat.ceylon.compiler.java.language;


import ceylon.language.Boolean;
import ceylon.language.Callable;
import ceylon.language.Category$impl;
import ceylon.language.Comparison;
import ceylon.language.Container$impl;
import ceylon.language.Entry;
import ceylon.language.Integer;
import ceylon.language.Iterable;
import ceylon.language.Iterable$impl;
import ceylon.language.Iterator;
import ceylon.language.Null;
import ceylon.language.SequenceBuilder;
import ceylon.language.Sequential;
import ceylon.language.finished_;

import com.redhat.ceylon.compiler.java.metadata.Class;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.metadata.SatisfiedTypes;
import com.redhat.ceylon.compiler.java.runtime.model.ReifiedType;
import com.redhat.ceylon.compiler.java.runtime.model.TypeDescriptor;

/** A non-user-visible class that's useful to create Iterables in generated bytecode.
 * The getIterator() method should return a new instance in every call.
 * 
 * @author Enrique Zamudio
 */
@Ignore
@Class(extendsType="ceylon.language::Object")
@SatisfiedTypes("ceylon.language::Iterable<Element,Absent>")
public abstract class AbstractIterable<Element,Absent> implements Iterable<Element,Absent>, ReifiedType {
    
    @Ignore
    protected final ceylon.language.Iterable$impl<Element, Absent> $ceylon$language$Iterable$this;
    @Ignore
    protected final ceylon.language.Container$impl<Element,Absent> $ceylon$language$Container$this;
    @Ignore
    protected final ceylon.language.Category$impl $ceylon$language$Category$this;
    @Ignore
    private TypeDescriptor $reifiedElement;
    @Ignore
    private TypeDescriptor $reifiedAbsent;

    public AbstractIterable(TypeDescriptor $reifiedElement, TypeDescriptor $reifiedAbsent) {
        this.$ceylon$language$Iterable$this = new ceylon.language.Iterable$impl<Element,Absent>($reifiedElement, $reifiedAbsent, this);
        this.$ceylon$language$Container$this = new ceylon.language.Container$impl<Element,Absent>($reifiedElement, $reifiedAbsent, this);
        this.$ceylon$language$Category$this = new ceylon.language.Category$impl(this);
        this.$reifiedElement = $reifiedElement;
        this.$reifiedAbsent = $reifiedAbsent;
    }
    
    @Ignore
    @Override
    public Category$impl $ceylon$language$Category$impl(){
        return $ceylon$language$Category$this;
    }

    @Ignore
    @Override
    public Container$impl<Element,Absent> $ceylon$language$Container$impl(){
        return $ceylon$language$Container$this;
    }

    @Ignore
    @Override
    public Iterable$impl<Element,Absent> $ceylon$language$Iterable$impl(){
        return $ceylon$language$Iterable$this;
    }
    
    @Override
    public long getSize() {
        return $ceylon$language$Iterable$this.getSize();
    }
    
    @Override
    public boolean getEmpty() {
        return getIterator().next() == finished_.getFinished$();
    }

    @Override
    @Ignore
    public Sequential<? extends Element> getSequence() {
        final SequenceBuilder<Element> sb = new SequenceBuilder<Element>($reifiedElement);
        java.lang.Object next = null;
        for (Iterator<? extends Element> iter = getIterator(); (next = iter.next()) != finished_.getFinished$();) {
            sb.append((Element) next);
        }
        return sb.getSequence();
    }
    
    @Override
    @Ignore
    public Element getFirst() {
    	return (Element) $ceylon$language$Iterable$this.getFirst();
    }
    @Override @Ignore 
    public Element getLast() {
        return (Element) $ceylon$language$Iterable$this.getLast();
    }

    @Override
    @Ignore
    public Iterable<? extends Element, ? extends java.lang.Object> getRest() {
    	return $ceylon$language$Iterable$this.getRest();
    }

    @Override
    public <Result> Iterable<? extends Result, ? extends java.lang.Object> map(
            TypeDescriptor $reifiedResult,
            Callable<? extends Result> collecting) {
        return new MapIterable<Element, Result>($reifiedElement, $reifiedResult, this, collecting);
    }

    @Override
    public Iterable<? extends Element, ? extends java.lang.Object> filter(
            Callable<? extends Boolean> selecting) {
        return new FilterIterable<Element,  Null>($reifiedElement, Null.$TypeDescriptor, this, selecting);
    }

    @Override
    @Ignore
    public <Result> Result fold(TypeDescriptor $reifiedResult,
            Result initial,
            Callable<? extends Result> accumulating) {
        return $ceylon$language$Iterable$this.fold($reifiedResult, initial, accumulating);
    }

    @Override @Ignore
    public Element find(Callable<? extends Boolean> selecting) {
        return $ceylon$language$Iterable$this.find(selecting);
    }

    @Override @Ignore
    public Element findLast(Callable<? extends Boolean> selecting) {
        return $ceylon$language$Iterable$this.findLast(selecting);
    }

    @Override 
    @Ignore
    public Sequential<? extends Element> sort(Callable<? extends Comparison> f) { 
        return $ceylon$language$Iterable$this.sort(f); 
    }
    @Override @Ignore
    public <Result> Sequential<? extends Result> collect(TypeDescriptor $reifiedResult, Callable<? extends Result> f) {
        return $ceylon$language$Iterable$this.collect($reifiedResult, f);
    }
    @Override @Ignore
    public Sequential<? extends Element> select(Callable<? extends Boolean> f) {
        return $ceylon$language$Iterable$this.select(f);
    }
    @Override @Ignore
    public boolean any(Callable<? extends Boolean> f) {
        return $ceylon$language$Iterable$this.any(f);
    }
    @Override @Ignore
    public boolean every(Callable<? extends Boolean> f) {
        return $ceylon$language$Iterable$this.every(f);
    }
    @Override @Ignore
    public Iterable<? extends Element, ? extends java.lang.Object> skipping(long skip) {
        return $ceylon$language$Iterable$this.skipping(skip);
    }
    @Override @Ignore
    public Iterable<? extends Element, ? extends java.lang.Object> taking(long take) {
        return $ceylon$language$Iterable$this.taking(take);
    }
    @Override @Ignore
    public Iterable<? extends Element, ? extends java.lang.Object> by(long step) {
        return $ceylon$language$Iterable$this.by(step);
    }
    @Override @Ignore
    public long count(Callable<? extends Boolean> selecting) {
        return $ceylon$language$Iterable$this.count(selecting);
    }
    @Override @Ignore
    public Iterable<? extends Element,?> getCoalesced() {
        return $ceylon$language$Iterable$this.getCoalesced();
    }
    @Override @Ignore
    public Iterable<? extends Entry<? extends Integer, ? extends Element>, ?> getIndexed() {
        return $ceylon$language$Iterable$this.getIndexed();
    }
    @Override @Ignore @SuppressWarnings("rawtypes")
    public <Other>Iterable chain(TypeDescriptor $reifiedOther, Iterable<? extends Other, ? extends java.lang.Object> other) {
        return $ceylon$language$Iterable$this.chain($reifiedOther, other);
    }
    @Override @Ignore
    public <Default>Iterable<?,?> defaultNullElements(TypeDescriptor $reifiedDefault, Default defaultValue) {
        return $ceylon$language$Iterable$this.defaultNullElements($reifiedDefault, defaultValue);
    }
    /*@Override @Ignore
    public <Key> Map<? extends Key, ? extends Sequence<? extends Element>> group(Callable<? extends Key> grouping) {
        return $ceylon$language$Iterable$this.group(grouping);
    }*/
    @Override @Ignore
    public boolean contains(java.lang.Object element) {
        return $ceylon$language$Iterable$this.contains(element);
    }
    @Override @Ignore
    public boolean containsEvery(Iterable<?,?> elements) {
        return $ceylon$language$Category$this.containsEvery(elements);
    }
//    @Override @Ignore
//    public boolean containsEvery() {
//        return $ceylon$language$Category$this.containsEvery();
//    }
//    @Override @Ignore
//    public Sequential<?> containsEvery$elements() {
//        return $ceylon$language$Category$this.containsEvery$elements();
//    }
    @Override @Ignore
    public boolean containsAny(Iterable<?,?> elements) {
        return $ceylon$language$Category$this.containsAny(elements);
    }
//    @Override @Ignore
//    public boolean containsAny() {
//        return $ceylon$language$Category$this.containsAny();
//    }
//    @Override @Ignore
//    public Sequential<?> containsAny$elements() {
//        return $ceylon$language$Category$this.containsAny$elements();
//    }
    @Override
    @Ignore
    public TypeDescriptor $getType() {
        return TypeDescriptor.klass(AbstractIterable.class, $reifiedElement);
    }
}
