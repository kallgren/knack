# No re-frame

re-frame is the canonical CLJS state-management library and will be reflexively suggested. We use a single CLJS atom plus a `use-subscribe` hook instead. re-frame's events/effects/co-effects machinery is unjustified at this scale — no async server, no complex flows, no time-travel-debugging need — and the localStorage-swap-to-database goal is served better by a small storage seam than by re-frame's effect handlers. Migration to re-frame later is well-trodden if we ever outgrow this shape.
