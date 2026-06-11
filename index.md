---
theme: uncover
---

![bg right:40% 80%](https://resources.jetbrains.com/storage/products/company/brand/logos/Rider_icon.svg)

# **Hello JetBrains Rider**

?‍♂️ JetBrains Rider Presentation Cool! ??️

https://jetbrains.com/rider

---

# How to write slides

Split pages by horizontal ruler (`---`). It's very simple! :clap:

```csharp
public static IEnumerable<int> Fibonacci(int n)
{
    int a = 0, b = 1;
    for (int i = 0; i < n; i++)
    {
        yield return a;
        int temp = a;
        a = b;
        b = temp + b;
    }
}
```

? Bugs, Bugs, Bugs, Bugs!

---

# A New Slide!

<div class="mermaid">
graph TD;
    A --> B;
    A --> C;
</div>

<!-- Add this anywhere in your Markdown file -->
<script type="module">
  import mermaid from 'https://cdn.jsdelivr.net/npm/mermaid@10/dist/mermaid.esm.min.mjs';
  mermaid.initialize({ startOnLoad: true });
</script>