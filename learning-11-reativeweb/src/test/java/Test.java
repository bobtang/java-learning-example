import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 响应是编程
 *
 * @author liupei
 * @date 2018/10/25 16:46
 */
public class Test {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(100);
        List<Integer> list1 = null;
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        //        Mono.just(list).flux().log("test").subscribe(System.out::println);
        //        Flux.just(list).log("test").subscribe(System.out::println);
        Flux<Integer> flux = Flux.create(System.out::println);
        int n = 1;
        //        Mono.just(list).flatMapMany(Flux::fromIterable).log("test").subscribe();
        //        Mono.never().log("test").subscribe(System.out::println);
        //        Flux.create(System.out::println).just(list).log("test-2").subscribe(System.out::println);
        //        Flux.just(list).flatMap(Flux::fromIterable).c
        //        Mono.create(System.out::println)
        //        Mono.just(list).subscribe(System.out::println);
        //        Mono.empty().log("test").subscribe(System.out::println);
        //        Mono.justOrEmpty(list1).subscribe(System.out::println);
        
        //        Mono.create(sink -> sink.success("create MonoSink")).subscribe(System.out::println);
        //        Mono.error(new RuntimeException("error")).subscribe(System.out::println, System.err::println);
        //        Flux flux1 = Mono.just(list).flatMapMany(Flux::fromIterable);
        //        Mono.just(list).flatMapMany(Flux::fromIterable).mergeWith(flux1).log("test").subscribe();
        //        Mono.just(list).mergeWith(Mono.just(list)).flatMap(Flux::fromIterable).log().subscribe();
        List<List<Integer>> lists1 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lists1.add(list);
        }
        
        //        Mono.just(list).map(list123 -> { list123.add(100); return list123;}).subscribe(System.out::println);
        //        System.out.println(list);
        
        //        Mono.just(lists1).flatMapMany(Flux::fromIterable).flatMap(Flux::fromIterable).log("list1").subscribe();
        //        Mono.just(lists1).flatMapMany(Flux::fromIterable).log().subscribe();
        
        //        Flux.range(0, 100).flatMap(key -> Mono.just(list.get(key))).subscribe(System.out::println);
       /* Flux.fromStream(list.stream()).flatMap(stream -> Mono.just(stream.toString())).index().log("test")
                .subscribe(System.out::println);*/
        
        /*Flux flux2 = Flux.fromStream(list.stream()).flatMap(stream -> Mono.just(stream.toString())).index();
        System.out.println(flux2.collect(Collectors.toList()).blockOptional().get());*/
        //        Mono.just(list).flatMapMany(Flux::fromIterable).skipUntil(num -> num == 2).log().subscribe(System.out::println);
        //        flux2.all(num -> num.hashCode() > 0).subscribe(System.out::println);
        
        //        List<Integer> all = Flux.fromIterable(list).collectList().block();
        //        System.out.println(all);
        //        System.out.println(list == all);
        List<Entity> entities = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            entities.add(new Entity(i, "liupei" + 1));
        }
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        
        Flux.combineLatest(Function.identity(), Flux.fromIterable(entities)).log("entity")
                .subscribe(mono -> System.out.println(mono[0].toString()));
        Flux.combineLatest(key -> {
            Flux.fromArray(key).subscribe(System.out::println);
            return key;
        }, Flux.fromStream(integers.stream()), Flux.fromStream(entities.stream())).log().subscribe(System.out::println);
        
        Flux.combineLatest(Flux.fromArray(integers.toArray()).concatWith(Flux.fromArray(integers.toArray())), Flux.fromArray(entities.toArray()),
                (a1, a2) -> {
                    System.out.println(a1);
                    System.out.println(a2);
                    return a1;
                }).subscribe();
        
        System.out.println(integers.toString());
        System.out.println(entities.toString());
        System.out.println(Flux.just(1).mergeWith(Flux.just(2)).take(2).collectList().block());
        /*Flux.combineLatest(key -> {
            Flux.fromArray(key).subscribe(System.out::println);
            return key;
        }, flux2, flux1).log()
                .subscribe(System.out::println);*/
        //        System.out.println(map);
        
    }
    
    @org.junit.Test
    public void combineLatest() {
        List<Entity> entities = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            entities.add(new Entity(i, "liupei" + 1));
        }
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        /*Flux.combineLatest(Function.identity(), Flux.fromIterable(integers).log()
                .map(Flux::just).log(), Flux.fromIterable(entities).log())
                .log()
                .subscribe(key -> Arrays.stream(key).forEach(value -> System.out.println(value.hashCode())));*/
        Flux.combineLatest(Function.identity(), Flux.fromIterable(integers).hide(), Flux.fromIterable(entities))
                .log()
                .subscribe(key -> Arrays.stream(key).forEach(value -> System.out.println(value.hashCode())));
    }
    
    static class Entity {
        private int id;
        private String name;
        
        public Entity(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        public int getId() {
            return id;
        }
        
        public String getName() {
            return name;
        }
    }
}
