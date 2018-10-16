function minimumSwaps(arr) {
    const touchedNodes = {};
    let currentSwaps = 0;
    let totalSwaps = 0;
    
    for (let i = 0; i < arr.length; ++i) {
        if (touchedNodes[i]) {
            continue;
        }
        
        touchedNodes[i] = true;
        let nextNode = arr[i] - 1;
        while (!touchedNodes[nextNode]) {
            ++currentSwaps;
            touchedNodes[nextNode] = true;
            nextNode = arr[nextNode] - 1;
        }

        if (currentSwaps >= 0) {
            totalSwaps = totalSwaps + currentSwaps;
            currentSwaps = 0;
        }
    };
    return totalSwaps;
}
