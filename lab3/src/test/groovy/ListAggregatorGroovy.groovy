import com.aor.numbers.ListAggregator
import spock.lang.Specification

class ListAggregatorGroovy extends Specification{

    def 'testing distinct bug 8726'() {
        given:
        def deduplicator = Mock(GenericListDeduplicator)
        def aggregator = new ListAggregator()
        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)

        when:
        def n_distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator)
        System.out.println(n_distinct)

        then:
        3 == n_distinct
    }
}
