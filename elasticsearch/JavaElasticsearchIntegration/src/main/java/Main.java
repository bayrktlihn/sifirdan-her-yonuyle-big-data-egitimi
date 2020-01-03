import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.index.reindex.DeleteByQueryRequestBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class Main {
	public static void main(String[] args) throws UnknownHostException {
		Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();

		TransportClient client = new PreBuiltTransportClient(settings)
				.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

//		List<DiscoveryNode> nodes = client.listedNodes();

//		for(DiscoveryNode node : nodes)
//			System.out.println(node);
//
//		Map<String, Object> json = new HashMap<>();
//		json.put("name", "Dell Inspiron 3585");
//		json.put("detail", "Intel Core i5, 8 gb ram, 1tb hardisk");
//		json.put("price", 3500);
//		json.put("provider", "Asus Türkiye");
//
//		IndexResponse res = client.prepareIndex("product", "_doc", "2").setSource(json, XContentType.JSON).get();
//
//		System.out.println(res.getId());

//		GetResponse response = client.prepareGet("product","_doc","1").get();
//		
//		Map<String, Object> source =  response.getSource();
//		
//		String name = source.get("name").toString();
//		String price = source.get("price").toString();
//		String detail = source.get("detail").toString();
//		String provider = source.get("provider").toString();
//		
//		
//		System.out.println(name + " " + price+ " " +provider+" "+detail);

//		SearchResponse response = client.prepareSearch("product").setTypes("_doc")
//				.setQuery(QueryBuilders.matchQuery("name", "Dell")).get();
//
//		SearchHit hits[] = response.getHits().getHits();
//		
//		for(SearchHit hit : hits)
//			System.out.println(hit.getSourceAsMap());

//		DeleteResponse response = client.prepareDelete("product", "_doc", "1").get();
//
//		System.out.println(response.getId());

		BulkByScrollResponse response = new DeleteByQueryRequestBuilder(client, DeleteByQueryAction.INSTANCE)
				.filter(QueryBuilders.matchQuery("name", "Dell")).source("product").get();
		long deleted = response.getDeleted();
		
		System.out.println(deleted);
	}
}
