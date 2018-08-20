# Sort Performance

Customers have complained about poor performance in an application view.

Performance monitoring has shown a specific "sorted Widget list" component to be a bottleneck. 
For now there is only one way to sort Widgets, a simple String comparison.

Getting the String to compare on is an expensive operation that cannot be optimized further.

How might this code be optimized?

To reset this challenge to its initial version:

```
git checkout tags/java/sortperformance
```
